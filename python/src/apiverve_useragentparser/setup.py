from setuptools import setup, find_packages

import os
lib_folder = os.path.dirname(os.path.realpath(__file__))
requirements_file = os.path.join(lib_folder, 'requirements.txt')
install_requires = ["requests >= 2.25.1", "setuptools >= 56.0.0"]
if os.path.exists(requirements_file):
    with open(requirements_file, 'r') as f:
        install_requires = f.read().splitlines()

setup(
    name='apiverve_useragentparser',
    version='1.1.13',
    packages=find_packages(),
    include_package_data=True,
    install_requires=install_requires,
    description='User Agent Parser is a simple tool for parsing user agent strings. It returns the browser, operating system, and more from the user agent string.',
    author='APIVerve',
    author_email='hello@apiverve.com',
    url='https://useragentparser.apiverve.com?utm_source=pypi&utm_medium=homepage',
    classifiers=[
        'Programming Language :: Python :: 3',
        'Operating System :: OS Independent',
    ],
    python_requires='>=3.6',
)