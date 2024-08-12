COMMAND="$1"
ARGs="$@"
PARAMs=(${ARGs// / })

function set_admin_client_pom_xml(){
    cat tool/etc/adminClient.pom.xml > pom.xml
}

function set_app_client_pom_xml(){
    cat tool/etc/appClient.pom.xml > pom.xml
}

function set_anonymous_client_pom_xml(){
    cat tool/etc/anonymousClient.pom.xml > pom.xml
}

function set_server_pom_xml(){
    cat tool/etc/server.pom.xml > pom.xml
}

function build_admin_client(){
    set_admin_client_pom_xml
    mvn clean package -DmainClass=cmd.AdminClient -DfinalName=adminClient
    rm pom.xml
}

function build_app_client(){
    set_app_client_pom_xml
    mvn clean package -DmainClass=cmd.AppClient -DfinalName=appClient
    rm pom.xml
}

function build_anonymous_client(){
    set_anonymous_client_pom_xml
    mvn clean package -DmainClass=cmd.AnonymousClient -DfinalName=anonymousClient
    rm pom.xml
}

function build_client(){
    build_admin_client
    build_app_client
    build_anonymous_client
}

function build_server(){
    set_server_pom_xml
    mvn clean package -DmainClass=cmd.Server -DfinalName=server
    rm pom.xml
}

function admin_client(){
    java -classpath "./build/admin/adminClient.jar:build/admin/vendor/*" cmd.AdminClient
}


function app_client(){
    java -classpath "./build/app/appClient.jar:build/app/vendor/*" cmd.AppClient
}

function anonymous_client(){
    java -classpath "./build/anonymous/anonymousClient.jar:build/app/vendor/*" cmd.AnonymousClient
}

function client(){
    admin_client
    app_client
    anonymous_client
}

function server(){
    java -jar ./target/server.jar
}

$COMMAND