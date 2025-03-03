package sktest.skava.util;

import com.google.common.base.Joiner;
import com.google.common.collect.Sets;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.shaneking.skava.util.Random0;
import org.shaneking.skava.util.UUID0;
import sktest.skava.SKUnit;
import sktest.skava.util.prepare.PrepareUUID0;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@RunWith(Parameterized.class)
public class UUID0Test extends SKUnit {
  private UUID uuid;

  public UUID0Test(UUID uuid) {
    super();
    this.uuid = uuid;
  }

  @Parameterized.Parameters
  public static List<Object[]> UUID0TestParameters() {
    return Arrays.asList(new Object[][]{{UUID.randomUUID()}, {UUID.randomUUID()}, {UUID.randomUUID()}});
  }

  @Test
  public void l19() {
    int r = Random0.nextMaxInt(100000);
    Set<String> set = Sets.newHashSet();
    for (int i = 0; i < r; i++) {
      set.add(UUID0.l19());
    }
    Assert.assertEquals(r, set.size());
    Assert.assertEquals(19 * r, Joiner.on("").join(set).length());
  }

  @Test
  public void cMl33() {
    Assert.assertEquals(33, UUID0.cMl33().length());
  }

  @Test
  public void cUl33() {
    Assert.assertEquals(33, UUID0.cUl33().length());
  }

  @Test
  public void dMl37() {
    Assert.assertEquals(37, UUID0.dMl37().length());
  }

  @Test
  public void dUl37() {
    Assert.assertEquals(37, UUID0.dUl37().length());
  }

  @Test
  public void l191() {
    int r = 2;
    Set<String> set = Sets.newHashSet();
    set.add(UUID0.l19(UUID.fromString("00000000-0000-0000-0000-000000000000")));
    set.add(UUID0.l19(UUID.fromString("ffffffff-ffff-ffff-ffff-ffffffffffff")));
    Assert.assertEquals(r, set.size());
    Assert.assertEquals(19 * r, Joiner.on("").join(set).length());
    System.out.println(Joiner.on("").join(set));
  }

  @Test
  public void l19P() {
    int r = 2;
    Set<String> set = Sets.newHashSet();
    set.add(UUID0.l19(uuid));
    set.add(UUID0.l19(UUID.randomUUID()));
    Assert.assertEquals(r, set.size());
    Assert.assertEquals(19 * r, Joiner.on("").join(set).length());
    System.out.println(Joiner.on("").join(set));
  }

  @Test
  public void to62String() {
    Assert.assertEquals(PrepareUUID0.testTo62String(-19000101, 62), "-1hINf");
    Assert.assertEquals(PrepareUUID0.testTo62String(19491001, 1), "19491001");
    Assert.assertEquals(PrepareUUID0.testTo62String(199606, 63), "199606");
  }

  @Test
  public void newInstance() {
    Assert.assertNotNull(String.valueOf(new UUID0()));
  }
}
