from setuptools import setup, find_packages

setup(
    name='apiverve_useragentparser',
    version='1.2.2',
    packages=find_packages(),
    include_package_data=True,
    install_requires=[
        'requests',
        'setuptools'
    ],
    description='User Agent Parser parses user agent strings to extract browser, operating system, and hardware details. It identifies device types, CPU architecture, and bot traffic, so you can run user agent detection on every incoming HTTP request.',
    author='APIVerve',
    author_email='hello@apiverve.com',
    url='https://apiverve.com/marketplace/useragentparser?utm_source=pypi&utm_medium=referral&utm_content=homepage',
    classifiers=[
        'Programming Language :: Python :: 3',
        'Operating System :: OS Independent',
    ],
    python_requires='>=3.6',
)
