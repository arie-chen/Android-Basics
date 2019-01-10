:uninstall
echo Trying to uninstall all versions of Anaconda...
cd C:\Anaconda
Uninstall-Anaconda.exe
cd C:\Anaconda3
Uninstall-Anaconda.exe

:download
echo Downloading Files...
mkdir C:\ee16A
bitsadmin /transfer "EE16AInstall" http://www-inst.eecs.berkeley.edu/~ee16a/sp16/install/install_files/unzip.exe C:\ee16A\unzip.exe
cd C:\ee16A
bitsadmin /transfer "EE16AInstall" http://inst.eecs.berkeley.edu/~ee16a/sp16/install/install_files/install_win64.zip C:\ee16A\install_win64.zip
unzip install_win64.zip -d C:\ee16A
del install_win64.zip
del unzip.exe

:anacondasetup
Anaconda3-2.3.0-Windows-x86_64.exe /S /D=C:\Anaconda3
call "%TEMP%\resetvars.bat"

:condapackages
conda update conda -y
conda install ipython=3.2.1 ipython-notebook=3.2.1 jinja2=2.8 mistune=0.7 tornado=4.2.1 jsonschema=2.4.0 pyqt=4.10.4 matplotlib=1.4.3 numpy=1.9.2 scipy=0.16.0 -y

:sdrsetup
pip install pyserial pyrtlsdr
copy rtlsdr_32\* C:\Anaconda3

:pyaudiosetup
::cd C:\ee16A
::pip install PyAudio-0.2.8-cp34-none-win_amd64.whl

:verify
bitsadmin /transfer "EE16AInstall" http://www-inst.eecs.berkeley.edu/~ee16a/sp16/install/check_version.py C:\ee16A\check_version.py
python C:\ee16A\check_version.py
