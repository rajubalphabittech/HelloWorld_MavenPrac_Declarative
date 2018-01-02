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
		maven "M3.5" //M3 is the name of the Maven tool configured in Jenkins Global Tool Configuration
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
			    /*
			    stage block should contain one and only one steps block
			    steps block contains the actual work of your stage.
			    */
			    steps{			    
				// Printing using Shell
				sh "echo Hello Shell"
				
				/* Printing using Batch */
				//bat "echo Hello Batch"
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
			    /* overriding globally defined agent */
			    agent{ docker 'ubuntu:latest' }
			    
			    steps{
				    timeout(time: 3, unit: 'MINUTES'){
					    // Print Hello to a samp.txt file
					    sh 'echo "Hello..I am going to a Hello.txt file" > Hello.txt'
				    }
			    }
		    }
		
		    stage("stage4"){
			/*
			tools{
				// Define the tools to be override the global tools defined.
			}
			*/
			    
			    
			/*
			stage block should contain atmost one and only one when block. It shouldn't be located inside steps block.
			*/
			when{
				// Check the branch is master
				branch "master"
				
				// check the environment variable "FIRSTNAME" has the value "Vish"
				environment name: "FIRSTNAME", value: "Vish"
				
				//Expressions. Only run if the expression doesn't return false/null.
				expression{
					return 3>2
				}
			}
			
			steps{
				sh "echo the branch is master"
				sh "echo Environment variable, FIRSTNAME has Vish as value"
				sh "echo expression satisfied"
				
				/* Keep trying this if it fails up to 5 times */
				retry(5){
					echo "--Attempted--"
				}
			}			
		    }
		
		    stage('stage-parallel'){
			steps{
				parallel (
				firstBlock: { sh "echo p1; sleep 5s; echo first block of stage-parallel" },
				secondBlock: { sh "echo p2; sleep 10s; echo second block of stage-parallel" }
				)			
			     }

			    //Lines of post block are logged. Not displayed in the pipeline.
			    post{
				 always{ echo "I am running inside a stages block" }
			    }
		    }
		    
		    stage("Clean"){
			    steps{
				    sh "mvn clean"
			    }
		    }
		
		    stage('Javadocs'){
			    steps{
				    //Generate javadocs for src code
				    sh "mvn javadoc:javadoc"
			    }
		    }

	            stage('Compile'){
			    steps{
				    //Compile code with Maven configured. M3 is the name given for Maven installation in Global Tool Configuration
				    sh "mvn compile"
			    }
	            }

	            stage('Unit-tests'){
			    steps{
				    //Unit test the compiled code with Maven test target.
				    sh "mvn test -DtestFailureIgnore=true"
				    //junit '**/target/surefire-reports/*.xml'
			    }	            
	            }

	            stage('Integration-tests'){
			    steps{
				    //Integration test the compiled code with Maven integration-test target.
				    sh "mvn integration-test"
			    }
	            }

	            stage('StaticCodeAnalysis'){
			    steps{
				    withSonarQubeEnv('sonarqube'){
					    //Maven clean. M3 is the name given for Maven installation in Global Tool Configuration
					    sh "mvn sonar:sonar -Dsonar.host.url=http://192.168.0.15:9000 -Dsonar.profile=vn_quality_profile1"
				    }
				    
				    sleep time: 2, unit: 'MINUTES'
				    timeout(time: 10, unit: 'MINUTES') {
					    script{
						    def qg = waitForQualityGate()
						    if (qg.status != 'OK') {
							    error "Pipeline aborted due to quality gate failure: ${qg.status}"
						    }
					    }
				    }
			    }
		    }
		
		    stage('TestReport'){ 
			    steps{
				    //Generate test report
				    sh "mvn surefire-report:report"
			    }
		    }
		
		    stage('MavenPackage'){
			    steps{
				    //Genarate package
				    sh "mvn package"
			    }
		    }
		
		   
	}
		
	/*
	Post block shouldn't be in a separate stage. Lines of post block are logged. 
	Steps inside post blcok aren't displayed in the pipeline.
	*/
	post{		
		success{ echo "I run only if the build is success." }
		failure{ echo "I run only if the build is failed." }
		unstable{ echo "I run only if the build is unstable." }		
		changed{ echo "I run only if the build status of the current build is different from the previous build." }
		always{	
			echo "Hi there? I run always irrespective of the build status"

			/* Wipeout the workspace after every build */
			//deleteDir()
		}	
	}
}
