/*
Resources: 
https://github.com/jenkinsci/pipeline-model-definition-plugin/wiki/Syntax-Reference 
*/
pipeline{
    	/* --- agent is a mandatory. It determines where your build runs ---
	
	"agent 'any'" - Run on any node
	"agent none" - Don’t run on a node at all. Manage node blocks yourself within your stages.
	"agent{ docker 'ubuntu:latest' }" - Run on any node within a Docker container of ubuntu image.
	
	*/
	//agent none // agent is a mandatory for declarative pipeline
	//agent any
	/*agent{
		docker "ubuntu:latest"
	}*/
	
	agent 'any'
	//agent{ docker 'ubuntu:latest' }
	/*agent{
		docker{
			image 'ubuntu:latest'
			//label 'docker-node'
		}
	}*/
	
	/* Tools - only works when *not* on docker or dockerfile agent */
	tools{
		maven "M3" //M3 is the name of the Maven tool configured in Jenkins Global Tool Configuration
	}
	
	/* environment is a block of key = value pairs that will be added to the envionment the build runs in. */
	environment{
		VERSION="1.0.0"
		ARTIFACT_NAME="Artifact_001"
		FIRSTNAME="Vish"
		LASTNAME="Manc"
		FULLNAME="${FIRSTNAME} ${LASTNAME}"
	}		
	
	stages{
		    stage("stage1"){
			    steps{			    
				// Printing using Shell
				sh 'echo "Hello Shell"'
			    }
		    }

		    stage("stage2"){
			    steps{
				 //  Print using default Sample step in Pipleine generaiong script
				 echo 'Hello...This message is printed using default Sample Step in Pipeline Script generator'
				 echo "Version is:  ${VERSION}"
				 echo "Full Name: ${FULLNAME}"
			    }
		    }

			    stage("stage3"){
				    steps{
					    timeout(time: 3, unit: 'MINUTES'){
						    // Print Hello to a samp.txt file
						    sh 'echo "Hello..I am going to a Hello.txt file" > Hello.txt'
					    }
				    }
			    }
		
		    stage('stage-parallel'){
			steps{
				parallel (
				phs1: { sh "echo p1; sleep 5s; echo phase1" },
				phs2: { sh "echo p2; sleep 10s; echo phase2" }
				)			
			     }

			    //Lines of post block are logged. Not displayed in the pipeline.
			    post{
				 always{ echo "I am running inside a stages block" }
			    }
		    }
		    
		    stage("Clean"){
			    steps{
				    maven "clean"
			    }
		    }
			
	}
	
	/*
	Post block shouldn't be in a separate stage. Lines of post block are logged. 
	Steps inside post blcok aren't displayed in the pipeline.
	*/
	post{		
		always{	echo "Hi there? I run always irrespective of the build status"	}		
		success{ echo "I run only if the build is success." }
		failure{ echo "I run only if the build is failed." }
		unstable{ echo "I run only if the build is unstable." }		
		changed{ echo "I run only if the build status of the current build is different from the previous build." }
	}
}

