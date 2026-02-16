from setuptools import setup, find_packages

setup(
    name='apiverve_ddgenerator',
    version='1.1.14',
    packages=find_packages(),
    include_package_data=True,
    install_requires=[
        'requests',
        'setuptools'
    ],
    description='D&D Generator creates random content for tabletop role-playing games including characters, NPCs, monsters, treasure, encounters, taverns, and quests.',
    author='APIVerve',
    author_email='hello@apiverve.com',
    url='https://apiverve.com/marketplace/dndgenerator?utm_source=pypi&utm_medium=homepage',
    classifiers=[
        'Programming Language :: Python :: 3',
        'Operating System :: OS Independent',
    ],
    python_requires='>=3.6',
)
