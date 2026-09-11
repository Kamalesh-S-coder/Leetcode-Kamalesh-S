// Last updated: 11/09/2026, 09:30:54
class Solution { 
    public List<List<String>> findDuplicate(String[] paths) { 
        List<List<String>> res = new ArrayList<>(); // This is where we'll store our final result: a list of lists. Each inner list will hold paths to duplicate files.  Think of it as the detective's report.
        Map<String, List<String>> map = new HashMap<>(); // This is our secret weapon! A map to store the content of the files (the key) and a list of the file paths that share that content (the value).  It's like a super-organized filing cabinet.

        // Let's go through each file path in the input.
        for (String path : paths) { //  Looping through each file path string. "path" variable currently represents a single path, like "dir1/file1.txt(content1)".
            String[] piece = path.split(" "); // Splitting the path string into parts, separated by spaces. The first part is the directory, and the rest are file names with their contents.
            for (int i = 1; i < piece.length; i++) { // Looping through the files in the current directory. Starts from index 1 because index 0 contains the directory.
                String[] inf = piece[i].split("\\("); // Splitting the file information (e.g., "file1.txt(content1)") into two parts using the "(" as a separator.
                // inf[0] is the filename (e.g., "file1.txt"), and inf[1] is the file content with a closing parenthesis (e.g., "content1)")
                String fullPath = piece[0] + "/" + inf[0]; // Creating the full path to the file by combining the directory path with the filename.
                String content = inf[1].substring(0, inf[1].length() - 1); // Extracting the file content without the trailing ')' parenthesis.

                // Is the content already in our map?
                if (map.containsKey(content)) {
                    // Yes!  We've found a duplicate!  Add the full path to the list of paths for that content.
                    map.get(content).add(fullPath);
                } else {
                    // Nope, this content is new to us. Create a new list and add the full path to that list.
                    List<String> pathsList = new ArrayList<>();
                    pathsList.add(fullPath);
                    map.put(content, pathsList); // Add the content and list of paths to the map.
                }
            }
        }

        // Now, let's go through our map and pick out the contents that have more than one file path (meaning there are duplicates).
        for (List<String> pathsList : map.values()) { // Looping through the values in the map (which are the lists of file paths).
            if (pathsList.size() > 1) { // If the list has more than one file path, then we found duplicates!
                res.add(pathsList); // Add this list of duplicate file paths to the result.
            }
        }

        return res; // Ta-da! Return the list of lists, where each inner list contains paths to duplicate files! The detective has solved the case!
    }
}