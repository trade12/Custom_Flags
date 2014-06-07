package mods.custom_flags.packet;

import ibxm.Player;

/**
 * Created by Aaron on 3/08/13.
 */
public abstract class AbstractPacket {

    public abstract void process(INetworkManager manager, Packet250CustomPayload packet, Player player);

}
