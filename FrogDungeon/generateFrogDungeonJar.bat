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

copy ..\..\lib\snakeyaml-1.23.jar snakeyaml-1.23.jar
tar xf snakeyaml-1.23.jar
echo d | xcopy /E /y .\org ..\org

cd ..
rmdir .\libs /s /q

rem jar cvfe ..\dist\%fileName% %mainClass% %package% processing org %resources%
jar cvfe ..\%fileName% %mainClass% %package% processing org %resources%

rmdir processing /s /q
rmdir org /s /q
rmdir -p /s /q

cd ..