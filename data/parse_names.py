#!/usr/bin/env python
# -*- coding: utf-8 -*-

from html.parser import HTMLParser
import sys
import re
import json

class PokeParser(HTMLParser):
        NUMBER = 1
        ENGLISH = 3
        TAIWAN = 4
        CHINA = 5
        HONGKONG = 6
        current_cell = 0
        pokemon_dict = {'number': '',
                        'english': '',
                        'taiwan': '',
                        'china': '',
                        'hongkong': ''}
        
        def handle_starttag(self, tag, attrs):
                if tag == 'td':
                        self.current_cell = self.current_cell + 1

        def handle_endtag(self, tag):
                if tag == "tr":
                        self.print_if_necessary()
                        self.current_cell = 0
                        self.pokemon_dict = self.init_dict()

        def handle_data(self, data):
                data = data.strip()
                self.set_data_if_necessary(data)

        def set_data_if_necessary(self, data):
                cell_name = self.get_cell_name(self.current_cell)
                if cell_name in self.pokemon_dict:
                        self.set_data_and_encode(data, cell_name)

        def get_cell_name(self, cc):
                if cc == self.NUMBER:
                        return 'number'
                elif cc == self.ENGLISH:
                        return 'english'
                elif cc == self.CHINA:
                        return 'china'
                elif cc == self.TAIWAN:
                        return 'taiwan'
                elif cc == self.HONGKONG:
                        return 'hongkong'
                else:
                        return 'undef'

        def set_data_and_encode(self, data, cell_name):
                new_data = self.pokemon_dict[cell_name] + '|' + data
                new_data = new_data.strip('|')
                self.pokemon_dict[cell_name] = new_data

        def print_if_necessary(self):
                if re.match(r'^[\d\?]{3}$', self.pokemon_dict['number']):
                        print(json.dumps(self.pokemon_dict))

        def init_dict(self):
                return {'number': '',
                        'english': '',
                        'china': '',
                        'taiwan': '',
                        'hongkong': ''}

parser = PokeParser()
filename = sys.argv[1]
with open(filename, 'r') as data_file:
        data = data_file.read()
        parser.feed(data)
