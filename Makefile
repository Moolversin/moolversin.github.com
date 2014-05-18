default:
	make compile
	make copy
	make push
compile:
	cd .. && lein run moolversin.github.com --compile
copy:
	cp public/* deploy/ -rf
push:
	cd deploy/ && git add . &&  git ci -am 'Update website' && git push origin gh-pages
