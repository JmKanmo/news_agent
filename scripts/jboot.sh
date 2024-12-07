#!/bin/bash

java -jar -Dwhatap.oname=news_agent -javaagent:/home/ec2-user/whatap/whatap_agent/news_agent_whatap/whatap.agent-2.2.24.jar news_agent-1.0.jar &