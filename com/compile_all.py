import sys
import os
from subprocess import Popen, PIPE, call

path = '.'

def file_exists(file_path):
    return os.path.isfile(file_path) if file_path else False

def main():
    for root, dirs, files in os.walk(path):
        if 'Makefile' in files:  # Verifica se existe um Makefile no diretório atual
            print('Checking', root)
            makefile = os.path.join(root, "Makefile")
            action = 'compile'  # Ação padrão é compilar
            if len(sys.argv) == 2:
                action = sys.argv[1]

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
    main()
