/*
Resources: 
https://github.com/jenkinsci/pipeline-model-definition-plugin/wiki/Syntax-Reference 
*/
pipeline{
    //def mvnhome = tool 'M3'
	//agent none // agent is a mandatory for declarative pipeline
	//agent any
	agent{
		docker "ubuntu:latest"
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
		    }
	    }

	    stage("stage3"){
		    steps{
			    timeout(time: 5, unit: 'MINUTES'){
				    // Print Hello to a samp.txt file
	    		            sh 'echo "I am going to a samp.txt file" > samp.txt'
			    }
		    }	    
	    }
		
	    stage('stage-parallel'){
	    	steps{
			parallel (
	     		phs1: { sh "echo p1; sleep 5s; echo phase1" },
	     		phs2: { sh "echo p2; sleep 10s; echo phase2" }
			)
			
			sleep 300
	    	     }
	
		    //Lines of post block are logged. Not displayed in the pipeline.
		    post{
			 always{ echo "I am running inside a stages block" }
		    }
	    }
		
	}

	
	//Lines of post block are logged. Not displayed in the pipeline.
	post{		
		always{	echo "Hi there? I run always irrespective of the build status"	}		
		success{ echo "I run only if the build is success." }
		failure{ echo "I run only if the build is failed." }
		unstable{ echo "I run only if the build is unstable." }		
		changed{ echo "I run only if the build status of the current build is different from the previous build." }
	}
}

