default:
	make compile
	make copy
	make commit
	make push
compile:
	cd .. && lein run moolversin.github.com --compile
copy:
	cp public/* deploy/ -rf
commit:
	cd deploy/ && git add . &&  git ci -am 'Update website'
push:
	cd deploy/ && git push origin gh-pages
