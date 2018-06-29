package graph.exceptions;

public class NodeException {

  public static class NodeAlreadyExistsException extends RuntimeException {
    public NodeAlreadyExistsException(String err) { super(err); }
  }

  public static class EdgeInvalidException extends RuntimeException {
    public EdgeInvalidException(String err) { super(err); }
  }

  public static class NonExistentNodeException extends RuntimeException {
    public NonExistentNodeException(String err) { super(err); }
  }
}
