package cc.chenzhihao.hi.framework.core.mark;

/**
 * 资源库 抽象接口
 *
 * @author jacksonchenzhihao
 * @date 2021-11-17 20:16
 */
public interface Repository<T extends Aggregate<ID>, ID extends Identifier> {

    /**
     * 通过ID寻找Aggregate
     *
     * @param id 唯一标识
     * @return 聚合根
     */
    T find(ID id);

    /**
     * 将一个Aggregate从Repository移除
     *
     * @param aggregate 聚合根
     */
    void remove(T aggregate);

    /**
     * 保存一个Aggregate
     *
     * @param aggregate 聚合根
     */
    void save(T aggregate);
}
