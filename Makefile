default:
	cd .. && lein run love-site-misaki --compile
	cp public/* deploy/ -rf
	cd deploy/ && git add . &&  git ci -am 'Update website' && git push origin gh-pages
