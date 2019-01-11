@echo off
rem
rem Root of TimesTen installed files
rem
set TTenDir=C:\TimesTen\TT1122~1\
set PERL5LIB=

rem
echo Setting environment variables for TimesTen
rem
%TTenDir%Perl\bin\perl %TTenDir%bin\envcfg -win > %TMP%\env.bat
%TMP%\env.bat
erase %TMP%\env.bat
