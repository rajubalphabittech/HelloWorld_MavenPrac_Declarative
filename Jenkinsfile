pipeline{
    //def mvnhome = tool 'M3'
	//agent none // agent is a mandatory for declarative pipeline
	agent any
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
			  // Print Hello to a samp.txt file
	    		  sh 'echo "I am going to a samp.txt file" > samp.txt'
		    }	    
	    }

	    /*
	    stage('stage-parallel'){
	    parallel (
	     phs1: { sh "echo p1; sleep 20s; echo phase1" },
	     phs2: { sh "echo p2; sleep 40s; echo phase2" }
		)
	     }
	     */
	}
}
