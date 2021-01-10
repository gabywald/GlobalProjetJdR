#!/usr/bin/python3
# -*- coding: utf-8 -*-

class IChingElement( object ) : 
    def __init__(self, ten, unit, upper, lower = None, descriptor = None, number = None ):
        self.ten = ten
        self.unit = unit
        self.upper = upper
        self.lower = lower
        self.descriptor = descriptor
        self.number = number
    
    def __str__(self) : 
        str = "%s\t%s\t%s\t%s\t%s\t%s" % ( self.ten, self.upper, self.unit, \
                                          self.lower, self.descriptor, self.number)
        return str