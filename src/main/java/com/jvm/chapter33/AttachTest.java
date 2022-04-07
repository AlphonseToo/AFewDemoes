//package com.jvm.chapter33;
//
//import com.sun.tools.attach.AgentInitializationException;
//import com.sun.tools.attach.AgentLoadException;
//import com.sun.tools.attach.AttachNotSupportedException;
//import com.sun.tools.attach.VirtualMachine;
//
//import java.io.IOException;
//
//public class AttachTest {
//
//    public static void main(String[] args) throws AttachNotSupportedException, IOException, AgentLoadException, AgentInitializationException {
//        if (args.length <= 1) {
//            System.out.println("Usage: java AttachTest <PID> /PATH/TO/AGENT.jar");
//            return;
//        }
//        VirtualMachine vm = VirtualMachine.attach(args[0]);
//        vm.loadAgent(args[1]);
//    }
//}
