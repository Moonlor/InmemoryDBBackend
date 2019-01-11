 Copyright (c) 1999, 2012, Oracle and/or its affiliates. All rights reserved. 

The bin subdirectory contains TimesTen utilities that can be used to 
maintain TimesTen data stores.  They are described briefly here, and 
in more detail in the Reference Guide.


Other files residing in this directory are for internal use only.

  General Purpose:
    ttIsql      --- linked with the ODBC Driver Manager

  Administration:
    ttUser
    ttenv.bat

  Debugging/Informational:
    ttCapture
    ttSchemaCS -- linked with the Client Library
    ttStatsCS
    ttVersion

  Maintenance:

The TimesTen utilities included in this installation are described below.


ttCapture
---------
This utility captures useful information about the current operating
system, TimesTen installation, and TimesTen data stores in order to
facilitate error diagnosis when communicating with TimesTen support.

Run ttCapture -help for a brief description of the command-line options.


ttVersion
---------
This utility prints out the version of TimesTen.


