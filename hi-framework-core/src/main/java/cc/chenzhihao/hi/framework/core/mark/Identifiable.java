package cc.chenzhihao.hi.framework.core.mark;

/**
 * 描述可被ID标识的对象
 *
 * @author jacksonchenzhihao
 * @date 2021-11-17 20:09
 */
public interface Identifiable<ID extends Identitier> {

    /**
     * 获取ID
     *
     * @return ID
     */
    ID getID();

}