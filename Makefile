default:
	cp public/* deploy/ -rf
	cd deploy/ && git add . &&  git ci -am 'Update website' && git push
