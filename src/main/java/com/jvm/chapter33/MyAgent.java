//package com.jvm.chapter33;
//
//import jdk.internal.org.objectweb.asm.tree.FieldInsnNode;
//import jdk.internal.org.objectweb.asm.tree.InsnList;
//import jdk.internal.org.objectweb.asm.tree.LdcInsnNode;
//import jdk.internal.org.objectweb.asm.tree.MethodInsnNode;
//import org.objectweb.asm.ClassReader;
//import org.objectweb.asm.ClassWriter;
//import org.objectweb.asm.Opcodes;
//
//import java.lang.instrument.ClassFileTransformer;
//import java.lang.instrument.IllegalClassFormatException;
//import java.lang.instrument.Instrumentation;
//import java.security.ProtectionDomain;
//
//public class MyAgent {
//
//
//    public static void premain(String args, Instrumentation instrumentation) {
//        instrumentation.addTransformer(new MyTransformer());
//    }
//
//    static class MyTransformer implements ClassFileTransformer, Opcodes {
//        public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined,
//                                ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
//            ClassReader cr = new ClassReader(classfileBuffer);
//            ClassNode classNode = new ClassNode(ASM7);
//            cr.accept(classNode, ClassReader.SKIP_FRAMES);
//
//            for (MethodNode methodNode : classNode.methods) {
//                if ("main".equals(methodNode.name)) {
//                    InsnList instrumentation = new InsnList();
//                    instrumentation.add(new FieldInsnNode(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;"));
//                    instrumentation.add(new LdcInsnNode("Hello, Instrumentation!"));
//                    instrumentation
//                            .add(new MethodInsnNode(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false));
//
//                    methodNode.instructions.insert(instrumentation);
//                }
//            }
//
//            ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES | ClassWriter.COMPUTE_MAXS);
//            classNode.accept(cw);
//            return cw.toByteArray();
//        }
//    }
//}
