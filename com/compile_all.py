import sys
import os
from subprocess import Popen, PIPE, call  # Adicionando 'call' ao import

path = '.'
action = 'compile'

def file_exists(file_path):
    return os.path.isfile(file_path) if file_path else False

def main():
    for root, dirs, files in os.walk(path):
        print('Checking', root)
        makefile = os.path.join(root, "Makefile")
        if file_exists(makefile):
            cmd = 'cd ' + root + '; make ' + action
            pipes = Popen(cmd, shell=True, stdout=PIPE, stderr=PIPE)
            std_out, std_err = pipes.communicate()

            if action in ('compile', 'run'):
                if pipes.returncode != 0:
                    err_msg = "%s. Code: %s" % (std_err.strip(), pipes.returncode)
                    print('[E] Error on {}: {}'.format(root, err_msg))
                elif len(std_err):
                    print('[OK]')
                else:
                    print('[OK]')
        if action == 'measure':
            call(['sleep', '5'])

if __name__ == '__main__':
    if len(sys.argv) == 2:
        act = sys.argv[1]
        if act in ('compile', 'run', 'clean', 'measure'):
            print('Performing "{}" action...'.format(act))
            action = act
        else:
            print('Error: Unrecognized action "{}"'.format(act))
            sys.exit(1)
    else:
        print('Performing "compile" action...')
        action = 'compile'

    main()