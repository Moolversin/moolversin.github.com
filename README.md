### Build instructions

```sh
git clone https://github.com/liquidz/misaki # clone misaki repo
cd misaki
git clone git@github.com:Moolversin/moolversin.github.com.git # clone this repo
git clone git@github.com:Moolversin/moolversin.github.com.git moolversin.github.com/deploy # clone this repo to deploy directiry also
cd moolversin.github.com/deploy && git checkout gh-pages
cd .. # go to project directory
make # build and push
```
