package framework.ecjdt;


import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.CompilationUnit;

import java.util.Map;

/**
 * @author jack.zhang
 * @since 2015/5/11
 */
public class JDT {
    public static void main(String[] args) {
        ASTParser parser = ASTParser.newParser(AST.JLS3); //����Java���Թ淶�汾
        parser.setKind(ASTParser.K_COMPILATION_UNIT);

        Map<String, String> compilerOptions = JavaCore.getOptions();
        compilerOptions.put(JavaCore.COMPILER_COMPLIANCE, JavaCore.VERSION_1_7); //����Java���԰汾
        compilerOptions.put(JavaCore.COMPILER_CODEGEN_TARGET_PLATFORM, JavaCore.VERSION_1_7);
        compilerOptions.put(JavaCore.COMPILER_SOURCE, JavaCore.VERSION_1_7);
        parser.setCompilerOptions(compilerOptions); //���ñ���ѡ��

        char[] src = "class A { void method1(int b){;} }".toCharArray();
        parser.setSource(src);

        CompilationUnit cu = (CompilationUnit) parser.createAST(null); //���������IProgessMonitor,����GUI�Ľ�����ʾ,���ǲ���Ҫ�����null. ����ֵ��AST�ĸ����

        System.out.println(cu); //��ASTֱ���������ɶ��
    }
}
