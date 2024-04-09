import sys
import os
from subprocess import Popen, PIPE, call

path = '.'

def file_exists(file_path):
    return os.path.isfile(file_path) if file_path else False

def main():
    for root, dirs, files in os.walk(path):
        print('Checking', root)
        makefile = os.path.join(root, "Makefile")
        if file_exists(makefile):
            cmd = 'cd {}; make compile'.format(root)
            pipes = Popen(cmd, shell=True, stdout=PIPE, stderr=PIPE)
            std_out, std_err = pipes.communicate()

            if pipes.returncode != 0:
                err_msg = "%s. Code: %s" % (std_err.strip(), pipes.returncode)
                print('[E] Error on {}: {}'.format(root, err_msg))
            elif len(std_err):
                print('[OK]')
            else:
                print('[OK]')

            # Após a compilação, execute o main.c se a ação for 'measure'
            if action == 'measure':
                main_c_path = os.path.join(os.sep, 'com', 'RAPL', 'main')
                if file_exists(main_c_path):
                    cmd_measure = '{} {}'.format(main_c_path, root)
                    call(cmd_measure, shell=True)

if __name__ == '__main__':
    action = 'compile'  # Ação padrão é compilar

    if len(sys.argv) == 2:
        act = sys.argv[1]
        if act in ('compile', 'run', 'clean', 'measure'):
            print('Performing "{}" action...'.format(act))
            action = act
        else:
            print('Error: Unrecognized action "{}"'.format(act))
            sys.exit(1)

    main()
