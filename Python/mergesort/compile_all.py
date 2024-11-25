import sys
import os
from subprocess import Popen, PIPE, call
from lazyme.string import color_print

path = '.'
action = 'compile'

def file_exists(file_path):
    return os.path.isfile(file_path) if file_path else False

def execute_command(root, action):
    makefile = os.path.join(root, "Makefile")
    if file_exists(makefile):
        cmd = f'cd {root}; make {action}'
        process = Popen(cmd, shell=True, stdout=PIPE, stderr=PIPE)
        std_out, std_err = process.communicate()
        
        if action in {'compile', 'run'}:
            if process.returncode != 0:
                err_msg = f"{std_err.strip().decode()}. Code: {process.returncode}"
                color_print(f'[E] Error on {root}: ', color='red', bold=True)
                print(err_msg)
            elif std_err:
                color_print('[OK]', color='green')
            else:
                color_print('[OK]', color='green')
        
        if action == 'measure':
            call(['sleep', '5'])

def main():
    for root, dirs, files in os.walk(path):
        print(f'Checking {root}')
        execute_command(root, action)

if __name__ == '__main__':
    if len(sys.argv) == 2:
        act = sys.argv[1]
        if act in {'compile', 'run', 'clean', 'measure'}:
            color_print(f'Performing "{act}" action...', color='yellow', bold=True)
            action = act
        else:
            color_print(f'Error: Unrecognized action "{act}"', color='red')
            sys.exit(1)
    else:
        color_print('Performing "compile" action...', color='yellow', bold=True)

    main()