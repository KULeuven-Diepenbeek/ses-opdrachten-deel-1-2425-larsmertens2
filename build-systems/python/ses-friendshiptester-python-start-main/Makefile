MAIN = app.py
TARGET = friendshiptester.bin

compile:
	pyinstaller --onefile --name friendshiptester.bin app.py

clean:
	-rm -R ./build/* 
	-rm -R ./dist/*

test: 
	python3 app.py

run: 
	@cd ./dist && ./friendshiptester.bin
