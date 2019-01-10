#!/usr/bin/env python
import subprocess
import time
import sys

# For color output
HEADER = '\033[95m'
OKBLUE = '\033[94m'
OKGREEN = '\033[92m'
WARNING = '\033[93m'
FAIL = '\033[91m'
ENDC = '\033[0m'
BOLD = '\033[1m'
UNDERLINE = '\033[4m'

# Package versions available with the "conda list" command
conda_versions=[("python", "3.4.3"),
#("portaudio", "19"),
("anaconda", "2.3.0"),
("ipython-notebook", "3.2.1"),
("pyqt", "4.10.4"),
("qt", "4.8.6")]

# Package versions available with the "pip show" command
pip_versions = [
("conda", "3.15.1"),
("conda-env", "2.3.0"),
("pip", "7.1.0"),
("setuptools", "18.0.1"),
("ipython", "3.2.1"),
("jinja2", "2.8"),
("mistune", "0.7"),
("tornado", "4.2.1"),
("jsonschema", "2.4.0"),
("matplotlib", "1.4.3"),
("numpy", "1.9.2"),
("pyserial", "2.7"),
("scipy", "0.16.0"),
#("pyaudio", "0.2.8"),
("pyrtlsdr", "0.2.0")]

try:
    assert sys.version_info >= (3, 0)
except:
    print(FAIL+"This program requires Python 3."+ENDC)
    quit()

# Make sure the latest version of pip in installed to avoid parsing errors
try:
  subprocess.check_output(["conda", "update", "pip"])
except:
  print(FAIL+"ERROR: Make sure the 'conda' and 'pip' commands are installed"+ENDC)
  quit()

# Get and parse conda output
packages = subprocess.check_output(["conda", "list", "--export"]).splitlines()[4:-1]

conda_packages = {}
for p in packages:
    module, version, python_version = str(p).split("=")
    conda_packages[module[2:]]=version

# Check conda output
print(BOLD+UNDERLINE+"{0:16} | {1:16} | {2:16}".format("Package Name", \
        "Required","Installed")+ENDC)

for p in conda_versions:
  try:
    v = conda_packages[p[0]]
    if p[1]==v:
      print(OKGREEN+"{0:16} | {1:16} | {2:16}".format(p[0], p[1], v)+ENDC)
    else:
      print(WARNING+"{0:16} | {1:16} | {2:16}".format(p[0], p[1], v)+ENDC)

    # Make lines print one at a time
    time.sleep(.4)

  except:
      print(FAIL+"{0:16} | {1:16} | {2:16}".format(p[0], p[1], "NOT FOUND")+ENDC)


# Check pip output
for p in pip_versions:
  try:
    v = str(subprocess.check_output(["pip", "show",\
            p[0]]).splitlines()[2:4][1]).split(" ")[1][:-1]
    if p[1]==v:
        print(OKGREEN+"{0:16} | {1:16} | {2:16}".format(p[0], p[1], v)+ENDC)
    else:
      print(WARNING+"{0:16} | {1:16} | {2:16}".format(p[0], p[1], v)+ENDC)
  except:
      print(FAIL+"{0:16} | {1:16} | {2:16}".format(p[0], p[1], "NOT FOUND")+ENDC)

print("")
