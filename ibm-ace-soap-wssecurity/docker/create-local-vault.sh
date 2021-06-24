#!/bin/bash
source /opt/ibm/ace-11/server/bin/mqsiprofile 

mqsivault --work-dir /home/aceuser/ace-server --create --vault-key ace-local-vault
mqsicredentials --work-dir /home/aceuser/ace-server --create --vault-key ace-local-vault --credential-type local --credential-name myCredential --username myUsername --password myPassw0rd