import os
import sys
from subprocess import Popen, PIPE, call
from lazyme.string import color_print

def file_exists(file_path):
    return os.path.isfile(file_path)

def execute_command(root, action):
    makefile = os.path.join(root, "Makefile")
    
    if file_exists(makefile):
        cmd = f'cd {root} && make {action}'
        process = Popen(cmd, shell=True, stdout=PIPE, stderr=PIPE)
        std_out, std_err = process.communicate()
        
        if process.returncode != 0:
            color_print(f'[E] Error in {root}: {std_err.strip().decode()}', color='red', bold=True)
        else:
            color_print(f'[OK] {root} - {action} completed', color='green')
        
        if action == 'measure':
            call(['sleep', '5'])

def main():
    path = '.'
    action = 'compile'
    
    if len(sys.argv) == 2:
        action = sys.argv[1]
        if action not in {'compile', 'run', 'clean', 'measure'}:
            color_print(f'Error: Unrecognized action "{action}"', color='red')
            sys.exit(1)
    
    color_print(f'Performing "{action}" action...', color='yellow', bold=True)
    
    for root, _, files in os.walk(path):
        if "Makefile" in files:
            print(f'Processing {root}...')
            execute_command(root, action)

if __name__ == '__main__':
    main()
