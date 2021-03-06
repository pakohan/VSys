package blatt7.server;

import java.io.IOException;
import java.util.Map;

import forum.framework.IForumView;
import forum.framework.Position;
import blatt7.gen.CorbaForumView;
import blatt7.gen.PositionedAvatar;

public class CorbaViewForwarder implements IForumView {

	private CorbaForumView view;

	public CorbaViewForwarder(CorbaForumView view) {
		this.view = view;
	}

	@Override
	public void notifyView(Map<String, Position> folks) throws IOException {
		PositionedAvatar[] pos = new PositionedAvatar[folks.size()];
		
		int i = 0;
		
		for (Map.Entry<String, Position> entry : folks.entrySet()) {
			
			pos[i] = new PositionedAvatar(
						entry.getKey(), new blatt7.gen.Position(
								entry.getValue().getX(), entry.getValue().getY()));
			
			i++;
		}
		
		this.view.notifyView(pos);
	}

}
