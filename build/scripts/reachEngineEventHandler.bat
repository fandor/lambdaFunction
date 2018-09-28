@if "%DEBUG%" == "" @echo off
@rem ##########################################################################
@rem
@rem  reachEngineEventHandler startup script for Windows
@rem
@rem ##########################################################################

@rem Set local scope for the variables with windows NT shell
if "%OS%"=="Windows_NT" setlocal

set DIRNAME=%~dp0
if "%DIRNAME%" == "" set DIRNAME=.
set APP_BASE_NAME=%~n0
set APP_HOME=%DIRNAME%..

@rem Add default JVM options here. You can also use JAVA_OPTS and REACH_ENGINE_EVENT_HANDLER_OPTS to pass JVM options to this script.
set DEFAULT_JVM_OPTS=""

@rem Find java.exe
if defined JAVA_HOME goto findJavaFromJavaHome

set JAVA_EXE=java.exe
%JAVA_EXE% -version >NUL 2>&1
if "%ERRORLEVEL%" == "0" goto init

echo.
echo ERROR: JAVA_HOME is not set and no 'java' command could be found in your PATH.
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

goto fail

:findJavaFromJavaHome
set JAVA_HOME=%JAVA_HOME:"=%
set JAVA_EXE=%JAVA_HOME%/bin/java.exe

if exist "%JAVA_EXE%" goto init

echo.
echo ERROR: JAVA_HOME is set to an invalid directory: %JAVA_HOME%
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

goto fail

:init
@rem Get command-line arguments, handling Windows variants

if not "%OS%" == "Windows_NT" goto win9xME_args

:win9xME_args
@rem Slurp the command line arguments.
set CMD_LINE_ARGS=
set _SKIP=2

:win9xME_args_slurp
if "x%~1" == "x" goto execute

set CMD_LINE_ARGS=%*

:execute
@rem Setup the command line

set CLASSPATH=%APP_HOME%\lib\reachEngineEventHandler-0.1.jar;%APP_HOME%\lib\function-aws-1.0.0.M4.jar;%APP_HOME%\lib\function-1.0.0.M4.jar;%APP_HOME%\lib\runtime-1.0.0.M4.jar;%APP_HOME%\lib\http-1.0.0.M4.jar;%APP_HOME%\lib\aop-1.0.0.M4.jar;%APP_HOME%\lib\inject-1.0.0.M4.jar;%APP_HOME%\lib\kotlin-stdlib-jdk8-1.2.31.jar;%APP_HOME%\lib\jackson-module-kotlin-2.9.4.1.jar;%APP_HOME%\lib\kotlin-reflect-1.2.31.jar;%APP_HOME%\lib\aws-lambda-java-events-1.0.0.jar;%APP_HOME%\lib\aws-java-sdk-s3-1.11.414.jar;%APP_HOME%\lib\aws-java-sdk-sns-1.11.414.jar;%APP_HOME%\lib\jackson-datatype-jdk8-2.9.6.jar;%APP_HOME%\lib\jackson-datatype-jsr310-2.9.6.jar;%APP_HOME%\lib\aws-java-sdk-kms-1.11.414.jar;%APP_HOME%\lib\aws-java-sdk-sqs-1.11.414.jar;%APP_HOME%\lib\aws-java-sdk-cognitoidentity-1.11.417.jar;%APP_HOME%\lib\aws-java-sdk-kinesis-1.11.417.jar;%APP_HOME%\lib\aws-java-sdk-core-1.11.417.jar;%APP_HOME%\lib\jmespath-java-1.11.417.jar;%APP_HOME%\lib\jackson-databind-2.9.6.jar;%APP_HOME%\lib\jackson-dataformat-cbor-2.6.7.jar;%APP_HOME%\lib\jackson-core-2.9.6.jar;%APP_HOME%\lib\logback-classic-1.2.3.jar;%APP_HOME%\lib\aws-lambda-java-log4j2-1.0.0.jar;%APP_HOME%\lib\log4j-slf4j-impl-2.9.1.jar;%APP_HOME%\lib\core-1.0.0.M4.jar;%APP_HOME%\lib\slf4j-api-1.7.25.jar;%APP_HOME%\lib\aws-lambda-java-core-1.1.0.jar;%APP_HOME%\lib\javax.inject-1.jar;%APP_HOME%\lib\snakeyaml-1.20.jar;%APP_HOME%\lib\validation-api-2.0.1.Final.jar;%APP_HOME%\lib\rxjava-2.2.0.jar;%APP_HOME%\lib\kotlin-stdlib-jdk7-1.2.31.jar;%APP_HOME%\lib\kotlin-stdlib-1.2.31.jar;%APP_HOME%\lib\logback-core-1.2.3.jar;%APP_HOME%\lib\log4j-core-2.9.1.jar;%APP_HOME%\lib\log4j-api-2.9.1.jar;%APP_HOME%\lib\jackson-annotations-2.9.0.jar;%APP_HOME%\lib\reactive-streams-1.0.1.jar;%APP_HOME%\lib\jsr305-3.0.2.jar;%APP_HOME%\lib\annotations-13.0.jar;%APP_HOME%\lib\httpclient-4.5.5.jar;%APP_HOME%\lib\commons-logging-1.2.jar;%APP_HOME%\lib\ion-java-1.0.2.jar;%APP_HOME%\lib\joda-time-2.8.1.jar;%APP_HOME%\lib\httpcore-4.4.9.jar;%APP_HOME%\lib\commons-codec-1.10.jar

@rem Execute reachEngineEventHandler
"%JAVA_EXE%" %DEFAULT_JVM_OPTS% %JAVA_OPTS% %REACH_ENGINE_EVENT_HANDLER_OPTS%  -classpath "%CLASSPATH%" io.micronaut.function.executor.FunctionApplication %CMD_LINE_ARGS%

:end
@rem End local scope for the variables with windows NT shell
if "%ERRORLEVEL%"=="0" goto mainEnd

:fail
rem Set variable REACH_ENGINE_EVENT_HANDLER_EXIT_CONSOLE if you need the _script_ return code instead of
rem the _cmd.exe /c_ return code!
if  not "" == "%REACH_ENGINE_EVENT_HANDLER_EXIT_CONSOLE%" exit 1
exit /b 1

:mainEnd
if "%OS%"=="Windows_NT" endlocal

:omega
