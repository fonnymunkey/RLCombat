package bettercombat.mod.network;

import bettercombat.mod.util.ScheduledPacketTask;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class PacketOffhandCooldown implements IMessage {

    public PacketOffhandCooldown() {
    
    }

    @Override
    public void fromBytes(ByteBuf buf) {
    
    }

    @Override
    public void toBytes(ByteBuf buf) {
    
    }

    public static class ServerHandler implements IMessageHandler<PacketOffhandCooldown, IMessage> {

        @Override
        public IMessage onMessage(PacketOffhandCooldown message, MessageContext ctx) {
            FMLCommonHandler.instance().getWorldThread(ctx.netHandler).addScheduledTask(new ScheduledPacketTask(ctx.getServerHandler().player));
            return null;
        }
    }

    @SideOnly(Side.CLIENT)
    public static class ClientHandler implements IMessageHandler<PacketOffhandCooldown, IMessage> {

        @Override
        public IMessage onMessage(PacketOffhandCooldown message, MessageContext ctx) {
            Minecraft.getMinecraft().addScheduledTask(new ScheduledPacketTask(Minecraft.getMinecraft().player));
            return null;
        }
    }
}