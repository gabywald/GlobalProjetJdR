#!/usr/bin/python3
# -*- coding: utf-8 -*- 

__author__ = "Gabriel Chandesris"
__copyright__ = "CC Gabriel Chandesris (2025)"
__credits__ = ""
__licence__ = "GNU GENERAL PUBLIC LICENSE v3"
__version__ = "1.0.0a"
__maintainer__ = "Gabriel Chandesris"
__email__ = "gabywald[at]laposte.net"
__contact__ = "gabywald[at]laposte.net"
__status__ = "Development"

class Computer( object ) : 
  """This class defines a Computer. """
  
  def __init__(self, name = None, comments = None ):
    """Computer Constructor. """
    self.name = name
    self.addins   = []
  
  def __str__(self) : 
    """Computer to str. """
    str = "Computer ( % s ) \n"  % (self.name)
    str += "\t addins: %s \n" % (self.addins)
    return str
  
  def appendAddin( self, addin) : 
    self.addins.append( addin )
  
