set package=frog
set mainClass=frog.Main
set fileName=FrogDungeon.jar
set resources=..\resources

cd bin

dir

mkdir -p libs

copy ..\lib\processing_core.jar .\libs\processing_core.jar
cd libs
tar xf processing_core.jar
echo d | xcopy /E /y processing ..\processing
cd ..
rmdir .\libs /s /q

rem jar cvfe ..\dist\%fileName% %mainClass% %package% processing %resources%
jar cvfe ..\%fileName% %mainClass% %package% processing %resources%

rmdir processing /s /q

cd ..