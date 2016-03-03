metadata {
	// Automatically generated. Make future change here.
	definition (name: "Thermostat Heat Button", namespace: "jcharr1", author: "Jason Charrier") {
		capability "Actuator"
		capability "Button"
		capability "Sensor"
        capability "Momentary"
        
        command "push"
        command "push1"
        command "hold1"

		fingerprint deviceId: "0x0101", inClusters: "0x86,0x72,0x70,0x9B", outClusters: "0x26,0x2B"
	}

	simulator {

	}
	tiles {
		standardTile("button", "device.button", width: 1, height: 1) {
			state "default", label: "Heat", icon: "st.thermostat.heat", backgroundColor: "#ffffff"
		}
 		standardTile("push1", "device.button", width: 1, height: 1, decoration: "flat") {
			state "default", label: "Push 1", backgroundColor: "#ffffff", action: "push1"
		} 
 		standardTile("hold1", "device.button", width: 1, height: 1, decoration: "flat") {
			state "default", label: "Hold 1", backgroundColor: "#ffffff", action: "hold1"
		}          
		main "button"
		details(["button","push1","hold1"])
	}
}

def parse(String description) {
}

def hold1() {
	sendEvent(name: "button", value: "held", data: [buttonNumber: "1"], descriptionText: "$device.displayName button 1 was held", isStateChange: true)
} 

def push1() {
	sendEvent(name: "button", value: "pushed", data: [buttonNumber: "1"], descriptionText: "$device.displayName button 1 was pushed", isStateChange: true)
}

def push() {
	log.debug "Executing 'push'"
	push1()
}