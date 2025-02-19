package server;
import client.ClientManager;
import coll.Commands;
import coll.Route;
import coll.TreeSetHandler;
import coms.*;

import java.util.ArrayDeque;
import java.util.Collection;

public class ServerManager implements Commands{
    private ClientManager clientManager;
    private ArrayDeque<AbstractCommand> coms= new ArrayDeque<>();
    private TreeSetHandler collhandler;
    //boolean helpFileExists = true;
    HelpReader hrd;
    History hst = new History();



    public ServerManager(ClientManager clientManager, TreeSetHandler collhandler) {
        this.clientManager = clientManager;
        this.collhandler = collhandler;
    }

    //public ServerManager() {}

    public void execute(){
        Response response;
        if(!coms.isEmpty()) response = new Response(coms.pollFirst().execute());
        else response = new Response("no commands to execute");

        clientManager.giveResponse(response);
    }

    public void addCommand(AbstractCommand com){
        coms.addLast(com);
        execute();
    }

    @Override
    public String save(String filename) {
        return "";
    }

    @Override
    public String load(String filename) {
        return "";
    }

    @Override
    public String add(Route route) {
        return collhandler.add(route);
    }

    @Override
    public String info() {
        return collhandler.info();
    }

    @Override
    public String show() {
        return "";
    }

    @Override
    public String update(Long id, Route route) {
        return "";
    }

    @Override
    public String removeById(long id) {
        return "";
    }

    @Override
    public String clear() {
        return "";
    }

    @Override
    public String executeScript(String fileName) {
        return "";
    }

    @Override
    public String exit() {
        return "";
    }

    @Override
    public String addIfMax(Route route) {
        return "";
    }

    @Override
    public String addIfMin(Route route) {
        return "";
    }

    @Override
    public String avgdistance() {
        return "";
    }

    @Override
    public String printAsc() {
        return "";
    }

    @Override
    public String printAscDist() {
        return "";
    }

    public void setClientManager(ClientManager clientManager) {
        this.clientManager = clientManager;
    }

    @Override
    public String showHistory() {
        return "";
    }
}
