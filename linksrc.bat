ECHO OFF
ECHO (Windows CMD) Linking source with MKLINK /J...
MKLINK /J build\forge\mcp\src\minecraft\io common\io
ECHO ================= WARNING! =================
ECHO REMOVE THE JUNCTION MANUALLY BEFORE REBUILD!
ECHO Failure to do so will wipe your source tree.
ECHO ============================================