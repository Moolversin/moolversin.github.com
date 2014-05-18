### Build instructions

```sh
git clone https://github.com/liquidz/misaki # clone misaki repo
cd misaki
git clone git@github.com:Gonzih/love-site-misaki.git # clone this repo
git clone git@github.com:Gonzih/love-site-misaki.git love-site-misaki/deploy # clone this repo to deploy directiry also
cd love-site-misaki/deploy && git checkout gh-pages
cd .. # go to project directory
make # build and push
```
