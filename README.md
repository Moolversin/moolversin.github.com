### Build instructions

```sh
# clone misaki repo
git clone https://github.com/liquidz/misaki misaki
# clone this repo
git clone git@github.com:Moolversin/moolversin.github.com.git misaki/moolversin.github.com
# clone this repo to deploy directiry also
git clone git@github.com:Moolversin/moolversin.github.com.git misaki/moolversin.github.com/deploy

cd misaki/moolversin.github.com
# switch to source branch
git checkout source
# build
make
```
