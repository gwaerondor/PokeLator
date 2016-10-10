#!/usr/bin/env python
# -*- coding: utf-8 -*-

from html.parser import HTMLParser
import sys
import re
import json

class PokeParser(HTMLParser):
        NUMBER = 1
        ICON = 2
        current_cell = 0
        pokemon_dict = {'number': '',
                        'icon': ''}
        
        def handle_starttag(self, tag, attrs):
                if tag == 'td':
                        self.current_cell = self.current_cell + 1
                elif tag == 'img':
                        if self.current_cell == 2:
                                image_data = attrs[1]
                                _, image_url = image_data
                                self.set_data_if_necessary(image_url)

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
                elif cc == self.ICON:
                        return 'icon'
                else:
                        return 'undef'

        def set_data_and_encode(self, data, cell_name):
                self.pokemon_dict[cell_name] = data

        def print_if_necessary(self):
                if re.match(r'^[\d\?]{3}$', self.pokemon_dict['number']):
                        print(self.dict_to_csv())

        def init_dict(self):
                return {'number': '',
                        'icon': ''}

        def dict_to_csv(self):
                s = '"{n}","{i}"'
                return s.format(n = self.pokemon_dict['number'],
                                i = self.pokemon_dict['icon'])

parser = PokeParser()
filename = sys.argv[1]
with open(filename, 'r') as data_file:
        data = data_file.read()
        parser.feed(data)
