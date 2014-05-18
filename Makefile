default:
	cd .. && lein run moolversin.github.com --compile
	cp public/* deploy/ -rf
	cd deploy/ && git add . &&  git ci -am 'Update website' && git push origin gh-pages
