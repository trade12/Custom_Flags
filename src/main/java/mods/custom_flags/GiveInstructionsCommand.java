package mods.custom_flags;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;

/**
 * User: nerd-boy
 * Date: 13/08/13
 * Time: 4:13 PM
 * TODO: Add discription
 */
public class GiveInstructionsCommand extends CommandBase {


    public String getCommandName()
    {
        return "cf.instructions";
    }

    /**
     * Return the required permission level for this command.
     */
    public int getRequiredPermissionLevel()
    {
        return 0;
    }

    public String getCommandUsage(ICommandSender par1ICommandSender)
    {
        return "commands.cf.instr.usage";
    }

    public void processCommand(ICommandSender par1ICommandSender, String[] par2ArrayOfStr)
    {
        EntityPlayerMP entityplayermp = getCommandSenderAsPlayer(par1ICommandSender);

        ItemStack instructions = new ItemStack(Items.written_book);
        NBTTagCompound nbt =  new NBTTagCompound();
        nbt.setString("title", "Custom Flags Instructions");
        nbt.setString("author", "Nerd-boy");

        NBTTagList pages = new NBTTagList("pages");

        BufferedReader br = null;

        try{
            br = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream("CustomFlagsInstructions.txt")));

            int page = 1;
            StringBuffer sb = new StringBuffer();
            while(br.ready()){
                String nextLine = br.readLine();
                System.out.println(nextLine);

                if(nextLine.equals("[pb]")){
                    pages.appendTag(new NBTTagString(String.valueOf(page), sb.toString()));
                    sb = new StringBuffer();
                    page++;
                }else{
                    sb.append(nextLine);
                    sb.append('\n');
                }

            }
        }catch (Exception e){
            pages.appendTag(new NBTTagString("1", "Error while reading help file"));
            e.printStackTrace();
        }finally {
            if(br != null){
                try{br.close();}
                catch(Exception e){e.printStackTrace();}
            }
        }

        nbt.setTag("pages", pages);


        instructions.setTagCompound(nbt);



        entityplayermp.inventory.addItemStackToInventory(instructions);
    }

}
