COMMAND="$1"
ARGs="$@"
PARAMs=(${ARGs// / })

function set_client_pom_xml(){
    cat tool/etc/client.pom.xml > pom.xml
}

function set_server_pom_xml(){
    cat tool/etc/server.pom.xml > pom.xml
}

function build_client(){
    set_client_pom_xml
    mvn clean package -DmainClass=cmd.Client -DfinalName=client
}

function build_server(){
    set_server_pom_xml
    mvn clean package -DmainClass=cmd.Server -DfinalName=server
}

$COMMAND