pipeline{
    def mvnhome = tool 'M3'
	stages{
	    /*stage("stage1"){
	    // Printing using Shell
	    sh 'echo "Hello Shell"'
	    }

	    stage("stage2"){
	    //  Print using default Sample step in Pipleine generaiong script
	    echo 'Hello...This message is printed using default Sample Step in Pipeline Script generator'
	    }

	    stage("stage3"){
	    // Print Hello to a samp.txt file
	    sh 'echo "I am going to a samp.txt file" > samp.txt'
	    }*/

	    /*
	    stage('stage-parallel'){
	    parallel (
	     phs1: { sh "echo p1; sleep 20s; echo phase1" },
	     phs2: { sh "echo p2; sleep 40s; echo phase2" }
		)
	     }
	     */

	    // This stage is required still we are building from Jenksfile. Because, while checking out the Jenkinsfile by the Jenkins job.. it will 
	    // Checkout only Jenkinsfile but not entire files.
	    stage('stage-Checkout'){
		    steps{
			    // Checkout the code from Git. Use 'git: Git' Sample step
		            git credentialsId: 'git_vishwa-m', url: 'https://github.com/vishwa-m/HelloWorld_MavenPrac_Declarative.git'
		    }
	     }

	    /*
	    //This portion is commented as Maven configuration is defined in the beginning.
	    stage('stage-Maven-Configuration'){
		def mvnhome = tool 'M3'
	    }*/

	    stage('stage-Maven-Clean'){
		steps{
			//Maven clean. M3 is the name given for Maven installation in Global Tool Configuration
			sh "${mvnhome}/bin/mvn clean"
		}
	    }

	    stage('stage-maven-java-docs'){
		 steps{
			//Generate javadocs for src code
			sh "${mvnhome}/bin/mvn javadoc:javadoc"
		 }
	    }

	    stage('stage-Maven-Compile'){
		//Compile code with Maven configured. M3 is the name given for Maven installation in Global Tool Configuration
		sh "${mvnhome}/bin/mvn compile"
	    }

	    stage('stage-Maven-UnitTests'){
		//Unit test the compiled code with Maven test target.
		sh "${mvnhome}/bin/mvn test -DtestFailureIgnore=true"

		//junit '**/target/surefire-reports/*.xml'
	    }

	    stage('stage-Maven-IntegrationTests'){
		//Integration test the compiled code with Maven integration-test target.
		sh "${mvnhome}/bin/mvn integration-test"
	    }

	    stage('stage-StaticCodeAnalysis'){
		 withSonarQubeEnv('sonarqube'){
		 //Maven clean. M3 is the name given for Maven installation in Global Tool Configuration
		 sh "${mvnhome}/bin/mvn sonar:sonar -Dsonar.host.url=http://192.168.0.15:9000 -Dsonar.profile=vn_quality_profile1"
		 }
	    }

	    stage("Quality Gate"){
		sleep time: 5, unit: 'MINUTES'
		timeout(time: 10, unit: 'MINUTES') {
		    def qg = waitForQualityGate()
		    if (qg.status != 'OK') {
			error "Pipeline aborted due to quality gate failure: ${qg.status}"
		    }
		}
	     }

	    stage('stage-Test-Report'){
		//Generate test report
		sh "${mvnhome}/bin/mvn surefire-report:report"
	    }

	    stage('stage-Maven-Package'){
		//Genarate package
		sh "${mvnhome}/bin/mvn package"
	    }

	    stage('stage-Artifacts_archival'){
		// archives the generated artifacts
		archiveArtifacts '**/target/*.jar'
	    }

	    /*stage('approve') {
		timeout(time: 15, unit: 'MINUTES') {
		input message: 'Do you want to continue?'
		}
		}*/

	    /*
	     stage('stage-Upload-Artifact'){
		sh "${mvnhome}/bin/mvn deploy:deploy"
	     }*/
	}
}
