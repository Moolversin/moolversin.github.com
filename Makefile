default:
	make compile
	make pull
	make copy
	make commit
	make push
compile:
	cd .. && lein run moolversin.github.com --compile
run:
	cd .. && lein run moolversin.github.com
copy:
	cp public/* deploy/ -rf
commit:
	cd deploy/ && git add . &&  git ci -am 'Update website'
pull:
	cd deploy/ && git pull origin master
push:
	cd deploy/ && git push origin master
