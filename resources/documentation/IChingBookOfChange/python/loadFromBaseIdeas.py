#!/usr/bin/python3
# -*- coding: utf-8 -*-

## Gabriel Chandesris (2021)

import re
import ModuleHelper
from IChingElement import IChingElement

listOfElts = []
descrIndex = 0
numberIndex = 0

dataBaseInitial = ModuleHelper.loadFileConfig( "someBasicDataClanofTwo" )

for line in dataBaseInitial : 
    if (not line.startswith("#") ) : 
        lineDetectionHeader = re.match( "^([0-9]) (.*?)\t([0-9])$", line)
        lineDetectionDescri = re.match( "^(.*?)\t(.*?)$", line)
        lineDetectionNumber = re.match( "^([0-9]+)$", line)
        if (lineDetectionHeader != None) :
            listOfElts.append( IChingElement( lineDetectionHeader.groups()[0], \
                                              lineDetectionHeader.groups()[2], \
                                              lineDetectionHeader.groups()[1] ) )
            ## print( IChingElement( lineDetectionHeader.groups()[0], \
            ##                                   lineDetectionHeader.groups()[2], \
            ##                                   lineDetectionHeader.groups()[1] ) )
        elif (lineDetectionDescri != None) :
            ## print( "%d / %d :: %s" % (descrIndex, len(listOfElts), lineDetectionDescri.groups()[1] ) )
            listOfElts[ descrIndex ].lower = lineDetectionDescri.groups()[0]
            listOfElts[ descrIndex ].descriptor = lineDetectionDescri.groups()[1]
            descrIndex += 1
        elif (lineDetectionNumber != None) :
            ## print( "%d / %d :: %s" % (numberIndex, len(listOfElts), lineDetectionNumber.groups()[0] ) )
            listOfElts[ numberIndex ].number = lineDetectionNumber.groups()[0]
            numberIndex += 1
        else : 
            pass
            ## print( "unknown: " + line )
    pass

for elt in listOfElts : 
    print( elt )